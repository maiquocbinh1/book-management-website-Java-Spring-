
import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [books, setBooks] = useState([]);
  const [form, setForm] = useState({ title: "", author: "" });
  const [editingId, setEditingId] = useState(null);

  const fetchBooks = () => {
    axios.get("http://localhost:8080/api/books")
      .then(res => setBooks(res.data))
      .catch(err => console.error(err));
  };

  useEffect(() => {
    fetchBooks();
  }, []);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (editingId === null) {
      axios.post("http://localhost:8080/api/books", form)
        .then(() => {
          fetchBooks();
          setForm({ title: "", author: "" });
        });
    } else {
      axios.put(`http://localhost:8080/api/books/${editingId}`, form)
        .then(() => {
          fetchBooks();
          setForm({ title: "", author: "" });
          setEditingId(null);
        });
    }
  };

  const handleEdit = (book) => {
    setForm({ title: book.title, author: book.author });
    setEditingId(book.id);
  };

  const handleDelete = (id) => {
    axios.delete(`http://localhost:8080/api/books/${id}`)
      .then(() => fetchBooks());
  };

  return (
    <div className="App">
      <h1>📚 Quản lý Sách</h1>
      <form onSubmit={handleSubmit}>
        <input name="title" placeholder="Tên sách" value={form.title} onChange={handleChange} required />
        <input name="author" placeholder="Tác giả" value={form.author} onChange={handleChange} required />
        <button type="submit">{editingId ? "Cập nhật" : "Thêm"}</button>
      </form>
      <ul>
        {books.map(book => (
          <li key={book.id}>
            <b>{book.title}</b> - {book.author}
            <button onClick={() => handleEdit(book)}>Sửa</button>
            <button onClick={() => handleDelete(book.id)}>Xoá</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;

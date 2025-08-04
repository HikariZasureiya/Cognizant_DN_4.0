import logo from "./logo.svg";
import "./App.css";


const showCourses = true;
const selectedBlog = 'react';


const Courses = ()=>{
  return(
    <div>
      <h2>Course Details</h2>
      <p>Angular - 4/5/2021</p>
      <p>React - 6/3/2021</p>
    </div>
  )
}

const BlogDetails = ()=>{

  return(
    <div>
  {selectedBlog === 'react' ? (
  <div>
    <h2>Blog Details</h2>
    <h3>React Learning</h3>
    <b>Stephen Biz</b>
    <p>Welcome to learning React!</p>
    <h3>Installation</h3>
    <b>Schwezdenier</b>
    <p>You can install React from npm.</p>
  </div>
) : (
  <p>No blog found</p>
)}
  
  </div>
)}



export const books = [
  { id: 101, bname: "Master React", price: 670 },
  { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
  { id: 101, bname: "Mongo Essentials", price: 450 },
];



const bookdet = (
  <ul>
    {books.map((book) => (
      <div key={book.id}>
        <h3>{book.bname}</h3>
        <h4>{book.price}</h4>
      </div>
    ))}
  </ul>
);

function App() {
  return (
    <div className="App">
      <div
        style={{display: "flex" , }}>
        <div className="st1">
          <h1>Course Details</h1>
          {showCourses && <Courses />}
        </div>
        
        <div>
          <div className="st2">
            <h1>Book Details</h1>
            {bookdet}
          </div>
        </div>

        <div className="st1">
          <div>
            <h1>Blog Details</h1>
             <BlogDetails />
          </div>
        </div>

      </div>
    </div>
  );
}

export default App;

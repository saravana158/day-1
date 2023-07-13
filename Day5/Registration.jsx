import React from 'react'
import { Link } from 'react-router-dom'

// import { Link } from 'react-router-dom';

// <Link to='/login'>Login</Link>
// import pic from "./logo1.jpg" ;
export default function Registration() {
  return (

    <div className='bod1'>
    <header class="header">
    <nav class="navigation">
    <h1></h1>
   <Link to='/'>Home</Link>
   <Link to=''>About</Link>
   <Link to='/res'>Restaurant</Link>
   <Link to=''>Contact</Link>
   <Link to='/login'>Login</Link>
    </nav>    
    </header>

   <div class='content'>
        <div class="content-h1">
        <div className='logo'>
            
        </div>
            <h3>Weclome to </h3>
            <div className='space'>
            <h3>Meredian Hotel</h3>
            </div>
        </div>
        <div>
            <button className='button'>Book Here</button>
        </div>
   </div>
   <br/><br/><br/><br/><br/>
   <br/><br/><br/><br/><br/><br/><br/><br/><br/>
   <div class="footer">
      <div class="heading">
        <h2>Faraz<sup>™</sup></h2>
      </div>
      <div class="content">
        <div class="services">
          <h4>Services</h4>
          <p><a href="#">App development</a></p>
          <p><a href="#">Web development</a></p>
          <p><a href="#">DevOps</a></p>
          <p><a href="#">Web designing</a></p>
        </div>
        <div class="social-media">
          <h4>Social</h4>
          <p>
            <a href="#"
              ><i class="fab fa-linkedin"></i> Linkedin</a
            >
          </p>
          <p>
            <a href="#"
              ><i class="fab fa-twitter"></i> Twitter</a
            >
          </p>
          <p>
            <a href="https://github.com/farazc60"
              ><i class="fab fa-github"></i> Github</a
            >
          </p>
          <p>
            <a href="https://www.facebook.com/codewithfaraz"
              ><i class="fab fa-facebook"></i> Facebook</a
            >
          </p>
          <p>
            <a href="https://www.instagram.com/codewithfaraz"
              ><i class="fab fa-instagram"></i> Instagram</a
            >
          </p>
        </div>
        <div class="links">
          <h4>Quick links</h4>
          <p><a href="#">Home</a></p>
          <p><a href="#">About</a></p>
          <p><a href="#">Blogs</a></p>
          <p><a href="#">Contact</a></p>
        </div>
        <div class="details">
          <h4 class="address">Address</h4>
          <p>
            Lorem ipsum dolor sit amet consectetur <br />
            adipisicing elit. Cupiditate, qui!
          </p>
          <h4 class="mobile">Mobile</h4>
          <p><a href="#">+91-12225*****</a></p>
          <h4 class="mail">Email</h4>
          <p><a href="#">farazc60@gmail.com</a></p>
        </div>
        <footer>
        <hr />
        © 2022 codewithFaraz.
        </footer>
        </div>
        </div>
      </div>
      
  )
}
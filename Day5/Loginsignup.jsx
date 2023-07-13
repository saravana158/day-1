import React, { useState } from 'react'
import './loginsignup.css'

function Loginsignup({ onClick }) {
  const [isSliderMoved, setSliderMoved] = useState(false);
  const [isFormSectionMoved, setFormSectionMoved] = useState(false);

  const handleSignupClick = () => {
    setSliderMoved(true);
    setFormSectionMoved(true);
  };

  const handleLoginClick = () => {
    setSliderMoved(false);
    setFormSectionMoved(false);
  };
  const handleCancelClick = () => {
    onClick();
  };
  return (
    <div className='bod4'>
      <div className="container">
        <div className="btn">
          <button type='submit'className="login" onClick={handleLoginClick}>
            Login
          </button>
          <button type='submit'className="signup" onClick={handleSignupClick}>
            Signup
          </button>
        </div>

        <div
          className={`slider ${isSliderMoved ? 'moveslider' : ''}`}
        ></div>
        <div
          className={`form-section ${isFormSectionMoved ? 'form-section-move' : ''
            }`}
        >
          <div className="login-box">
            <input
              type="email"
              className="email ele"
              placeholder="Email@example.com"
              required
            />
            <input
              type="password"
              className="password ele"
              placeholder="password"
            />
            <div className='cc'>
              <button type='submit'className="clkbtn">Login</button>
              <button className="clkbtn" onClick={handleCancelClick}>Cancel</button>
            </div>
          </div>

          <div className="signup-box">
            <input
              type="text"
              className="name ele"
              placeholder="Enter your name"
            />
            <input
              type="email"
              className="email ele"
              placeholder="Email@example.com"
            />
            <input
              type="password"
              className="password ele"
              placeholder="password"
            />
            <input
              type="password"
              className="password ele"
              placeholder="Confirm password"
            />
            <div className='cc'>
              <button type='submit'className="clkbtn">Signup</button>
              <button type='submit'className="clkbtn" onClick={handleCancelClick} >Cancel</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Loginsignup
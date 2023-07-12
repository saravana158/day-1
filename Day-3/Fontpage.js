import './App.css';
// import profile from "./image/a.png";
// import email from "./image/email.jpg";
// import pass from "./image/pass.png";
function FontPage() {
  return (
  <div class="login-box">
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQp9oDq8rMYrlwUa1iYtxonc-6kkVqe5u5wN-t2nbupwpTkY1qKWg58gkbDMhCRodgpipM&usqp=CAU" class="avatar"></img>
		<h1>Login Here</h1>
		<form>
			<p>Username</p>
			<input type="text" name="username" placeholder="Enter Username"/>
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter Password"/>
      <p>Email</p>
      <input type="text" name="username" placeholder="Email"/>
			<input type="submit" name="submit" value="Login"/>
   			<div class="invit-only">
				
			</div>
			<a href="#">Sign Up</a><br/>
      <br>
      </br>
			<a href="#">Forgot your password?</a><br/>
			
		</form>
	</div>
  );
}
export default FontPage;

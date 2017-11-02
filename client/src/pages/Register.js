import React, { Component } from 'react'

import auth from "../authorization/auth";

class Register extends Component {
  constructor() {
    super();
    this.state = { err: "", user: {username:"",password:""} }
}

  handleSubmit = (event) => {
    event.preventDefault()
    const user = this.state.user.username;
    const pass = this.state.user.password;
    auth.login(user, pass, (err, loggedIn) => {
      if (err) {
        return this.setState({ err: err.errorMessage });
      }
      this.setState({ err: "" });
      this.props.history.push("/");
    });
  }

  onChange = (e) => {
    const propertyName = e.target.id;
    const value = e.target.value;
    let user = this.state.user;
    user[propertyName] = value;
    this.setState({user});
  }

  render() {
    return (
      <div className="container">
        <form className="form-signin" onSubmit={this.handleSubmit}>
          <h2 className="form-signin-heading">Please register</h2>

          <label htmlFor="inputEmail" className="sr-only">Username</label>
          <input type="text" value={this.state.user.username} onChange={this.onChange} className="form-control" id="username" placeholder="User Name" required autoFocus />

          <label htmlFor="inputPassword" className="sr-only">Password</label>
          <input type="password" value={this.state.user.password} onChange={this.onChange} id="password" className="form-control" placeholder="Password" required />

          <label htmlFor="inputFirstName" className="sr-only">First name</label>
          <input type="text" value={this.state.user.firstName} onChange={this.onChange} id="firstname" className="form-control" placeholder="First Name" required />

          <label htmlFor="inputPhoneNumber" className="sr-only">Last name</label>
          <input type="number" value={this.state.user.lastName} onChange={this.onChange} id="lastname" className="form-control" placeholder="Last Name" required />

          <button className="btn btn-lg btn-primary btn-block" type="submit">Register</button>
          <br />
        </form>
        { this.state.err && ( 
          <div className="alert alert-danger errmsg"  role="alert"> 
            {this.state.err}
          </div>
        )}
      </div>
    )
  }
}

export default Register;

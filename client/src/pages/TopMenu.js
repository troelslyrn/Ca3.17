import React, { Component } from 'react'
import { Link } from "react-router-dom";
import auth from '../authorization/auth'

class TopMenu extends Component {

  constructor(props){
    super(props);
    this.state = {loggedIn: auth.loggedIn, userName:auth.userName,isUser:false,isAdmin:true}
  }

  loginStatus = (status,userName,isUser,isAdmin) =>{
    this.setState({loggedIn: status, userName,isUser,isAdmin});
  }

  componentDidMount(){
     auth.setLoginObserver(this.loginStatus);
  }

  render() {

    const logInStatus = this.state.loggedIn ? "Logged in as: " + this.state.userName : "";
    //console.log("RENDERING - REMOVE ME",JSON.stringify(this.state));
    return (
      <div>
        <nav className="navbar navbar-default" >
          <div className="container-fluid">
            <div className="navbar-header">
              <a className="navbar-brand" href="/" style={{pointerEvents: "none"}}>Semester Seed</a>
            </div>
            <ul className="nav navbar-nav">
              {this.state.isUser && (<li><Link to="/location">Locations</Link></li>)}
              {this.state.isAdmin && (<li><Link to="/admin">Admin page</Link></li>)}
            </ul>
            <ul className="nav navbar-nav navbar-right">
              <li className="navbar-text" style={{ color: "steelBlue" }}>{logInStatus}</li>
              <li>
              {this.state.loggedIn ? (
                    <li></li>
            ) : (
            <Link to="/register">Sign up</Link>
              )}
              </li>
              <li>
                {this.state.loggedIn ? (
                    <Link to="/logout"><span className="glyphicon glyphicon-log-out"></span> Logout</Link>
                  ) : (
                    <Link to="/login">
                      <span className="glyphicon glyphicon-log-in"></span> Login </Link>
                  )}
              </li>
              
            </ul>
          </div>
        </nav>
        
      </div>
    )
  }
}


  export default TopMenu;
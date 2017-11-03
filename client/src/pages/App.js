import React from "react"
import {Route, Switch } from "react-router-dom"
import Register from "./Register";
import Login from "./Login";
import Logout from "./Logout";
import Locations from "./Locations";
import AdminPage from "./AdminPage";
import TopMenu from "./TopMenu";


function App() {
  return (
    <div>
      <TopMenu />
      <Switch>
        <Route path="/register" component={Register} />
        <Route path="/login" component={Login} />
        <Route path="/logout" component={Logout} />
        <Route path="/locations" component={Locations} />
        <Route path="/admin" component={AdminPage} />
      </Switch>
    </div>
  )
}
export default App;
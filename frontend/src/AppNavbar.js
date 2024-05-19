import React, {Component} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return  <nav className="navbar navbar-dark bg-dark">
            <div className="container-fluid">
                <a className="navbar-brand " href="/">
                    BookShop
                </a>
            </div>
        </nav>
    }
}
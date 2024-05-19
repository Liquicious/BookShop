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
        return <div>
            <ul className={'nav nav-pills flex-column'}>
                <li className={'nav-item text-black fs-4'}>
                    <a href="/book" className={'nav-link text-black fs-5'} aria-current='page'>
                        <span className={'ms-2'}>
                            Books
                        </span>
                    </a>
                </li>
                <li className={'nav-item text-black fs-4'}>
                    <a href="/warehouse" className={'nav-link text-black fs-5'} aria-current='page'>
                        <span className={'ms-2'}>
                            Warehouses
                        </span>
                    </a>
                </li>
                <li className={'nav-item text-black fs-4'}>
                    <a href="/staff" className={'nav-link text-black fs-5'} aria-current='page'>
                        <span className={'ms-2'}>
                            Staff
                        </span>
                    </a>
                </li>
                <li className={'nav-item text-black fs-4'}>
                    <a href="/supplier" className={'nav-link text-black fs-5'} aria-current='page'>
                        <span className={'ms-2'}>
                            Suppliers
                        </span>
                    </a>
                </li>
                <li className={'nav-item text-black fs-4'}>
                    <a href="/order" className={'nav-link text-black fs-5'} aria-current='page'>
                        <span className={'ms-2'}>
                            Orders
                        </span>
                    </a>
                </li>
            </ul>
        </div>;
    }
}
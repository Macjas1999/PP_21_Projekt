import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const genericStyle = {
  color: '',
};

const visitStyle = {
  color: 'red',
};

class SingleAircraft extends React.Component {
  constructor(props) {
    super(props);
    this.setVisited = this.setVisited.bind(this);
    this.state = {visit: null};
    //this.setMilitary = this.setMilitary.bind(this);
    //this.state = {military: null};
  }

  static getDerivedStateFromProps(props, state) {
    if (state.visit === null)
      return {visit: props.visit};
    else
      return {};
  }

  setVisited = () => {
    if (this.state.visit) {
      this.setState({visit: false}, this.props.update(this.props.id, !this.state.visit));
    } else {
      this.setState({visit: true}, this.props.update(this.props.id, !this.state.visit));
    }
  }


  render() {
    const {value} = this.props;
    const {visit} = this.state;

    return (
      <React.Fragment>
        {visit === true ?
          <th style={visitStyle}>
            {value}
          </th> :
          <th style={genericStyle}>
            {value}
          </th>}
        <th>
          <button onClick={this.setVisited}>
            Change status
          </button>
        </th>
      </React.Fragment>
    )

  };
}

export default SingleAircraft;

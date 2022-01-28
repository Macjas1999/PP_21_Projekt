import React from "react";
import SingleAircraft from "./SingleAircraft";
import axios from "axios";

class AircraftList extends  React.Component {
  constructor(props) {
    super(props);
    this.addAircraft = this.addAircraft.bind(this);
    this.counter = 0;
  };

  addAircraft = () => {
    this.counter++;
    let newElement = {id: this.counter, value: this.state.newNew};
    this.setState(prevState => ({
      listElem: [...prevState.listElem, newElement],
      newNew: ""
    }), () => axios.post(`http://localhost:8080/api/aircrafts`, newElement));
  };

  // handleRemove = id => {
  //   let object = this.state.listElem.find(function (item) {
  //     if(item.id === id) return item;
  //   });
  //   let arrAfterDel = this.state.listElem.filter(function (item) {
  //     return item.id !== id
  //   });
  //   this.setState({listElem: arrAfterDel}, () => axios.delete(`http://localhost:8080/api/aircrafts/${object.id}`, object));
  // }

  myChangeHandler = (event) => {
    this.setState({newNew: event.target.value});
  }

  updateChild = (id, registration_number, type, manufacturer, model) => {
    let arrAfterUpdate = this.state.listElem.map(function (item) {
      if(item.id === id) item.registration_number = registration_number
      item.type = type
      item.manufacturer = manufacturer
      item.model = model;
      return item;
    });

    let object = arrAfterUpdate.find(function (item) {
      if(item.id === id) return item;
    });

    this.setState({listElem: arrAfterUpdate}, () => axios.put(`http://localhost:8080//api/aircrafts/${object.id}`, object));

    console.log(arrAfterUpdate);
  };

  componentDidMount() {
    axios.get(`http://localhost:8080/api/aircrafts`)
      .then(res => {
        const listElem = res.data;
        this.setState({ listElem });
      })
  }



  render() {

    const { listElem } = this.state;

    let elements = listElem.map(element => {
      return (<tr key={element.id}>
        <SingleAircraft registration_number={element.registration_number}
                        type={element.type}
                        manufacturer={element.manufacturer}
                        model={element.model}
                        id = {element.id}
              update={(id, registration_number, type, manufacturer, model) => this.updateChild(id, registration_number, type, manufacturer, model)}  />
      </tr>);
    })


  //  registration_number, type, manufacturer, model

    return (
      <div className="AircraftList">
        <h1>Aircraft List {this.props.name}</h1>
        <table className="table table-striped">
          <thead className="thead-dark">
          <th scope="col">registration_number</th>
          <th scope="col">type</th>
          <th scope="col">manufacturer</th>
          <th scope="col">model</th>
          <th scope="col"> </th>
          </thead>
          <tbody>
          {listElem}
          </tbody>
        </table>
        <p> New aircraft </p>
        <input
          type='text'
          onChange={this.myChangeHandler}
        />
        <button onClick={this.addAircraft}>
          Add Aircraft
        </button>
      </div>
    );
  }
}
export  default  AircraftList;


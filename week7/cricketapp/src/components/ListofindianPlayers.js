import { Component } from "react";

export class ListofindianPlayers extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return ( 
      <div>
      
        <ul>
           { this.props.players.map((player, index) => {
          return <li>{player}</li>;
        })}
        </ul>
      </div>
    );
  }
}

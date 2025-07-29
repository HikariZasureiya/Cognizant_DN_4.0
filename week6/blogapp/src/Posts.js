import { Component } from "react";
import Post from "./Post";
    export class Posts extends Component{
        constructor(props){
            super(props);
             this.state = {
                posts: []
            };
        }
        loadPosts(){
            fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {
                const postarr = data.map((item , index)=> new Post(index , item.title , item.body));
                console.log(postarr); 
                this.setState({ posts: postarr });
            })
            .catch(error => {
                console.error("Error fetching posts:", error);
            });
        }

        componentDidMount(){
            this.loadPosts();
        }

        render(){ 
            return (
            <div
                style={{
                    width:"full",
                    height:"full",
                    display:"flex",
                    flexDirection:"column",
                    textAlign:"center",
                    background: "#EEAECA",
                    background: "radial-gradient(circle,rgba(238, 174, 202, 1) 0%, rgba(148, 187, 233, 1) 100%)"
                }}
            >
                {this.state.posts.map((item , index)=>(
                        <div key={index}>
                            <h1
                            style={{color:"red"}}
                            >{item.title}</h1>
                            <h3>{item.body}</h3>
                        </div>
                ))}
            </div>
            
        );
        }

        componentDidCatch(error , info){
            console.error(error);
            console.warn(info);
        }

    }


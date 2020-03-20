import React, { Component } from 'react';
import Container from './Container';
import '../App.css';
import { getAllStudents } from "../server.js";
import {
  Table,
  Avatar,
  Spin
} from 'antd';

class App extends Component {

  state = {
    students: [],
    isFetching: false
  }

  componentDidMount() {
    this.fetchStudents();
  }

  fetchStudents = () => {
    this.setState({
      isFetching: true
    });

    getAllStudents() 
      .then(res => res.json()
      .then(students => {
        console.log(students);
        this.setState({
          students,
          isFetching: false
        });
      }));
  }

  render() {
    const { students, isFetching } = this.state;
    // getAllStudents().then(res => res.json().then(students => {
    //   console.log(students);
    // }));
    if(isFetching) {
      return (
        <Container>
          <Spin />
        </Container>
      );
    }

    if(students && students.length) {
      const columns = [
        {
          title: '',
          key: 'avatar',
          render: (text, student) => (
            <Avatar size='large'>
              {`${student.firstName.charAt(0).toUpperCase()}${student.lastName.charAt(0).toUpperCase()}`}
            </Avatar>
          )
        },
        {
          title: 'Student Id',
          dataIndex: 'studentId',
          key: 'studentId'
        },
        {
          title: 'First Name',
          dataIndex: 'firstName',
          key: 'firstName'
        },
        {
          title: 'Last Name',
          dataIndex: 'lastName',
          key: 'lastName'
        },
        {
          title: 'Email',
          dataIndex: 'email',
          key: 'email'
        }, 
        {
          title: 'Gender',
          dataIndex: 'gender',
          key: 'gender'
        }
      ];

      return (
        <Container>
          <Table 
          dataSource={students} 
          columns={columns} 
          pagination={false}
          rowKey='studentId' />
         </Container>
      );
    

      // return students.map((student, index) => {
      //   return(
      //   <div key={index}>
      //     <h3>{student.studentId}</h3>
      //     {student.firstName} <br />
      //     {student.lastName} <br />
      //     {student.email} <br />
      //     {student.gender} <br />
      //   </div>
      //   )
      // })
    }

    return (
      <div className="App">
        <h1>No Students found</h1>
      </div>
    );
  }
}

export default App;

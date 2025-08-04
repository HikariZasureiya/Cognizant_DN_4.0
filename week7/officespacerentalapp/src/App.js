// src/App.js
import React from 'react';

const offices = [
  {
    name: "TechNest Hub",
    rent: 55000,
    address: "Koramangala, Bangalore",
    image: "https://img.freepik.com/free-photo/modern-office-space-interior_158595-5206.jpg"
  },
  {
    name: "InnovateSpace",
    rent: 75000,
    address: "MG Road, Bangalore",
    image: "https://t4.ftcdn.net/jpg/03/84/55/29/360_F_384552930_zPoe9zgmCF7qgt8fqSedcyJ6C6Ye3dFs.jpg"
  },
  {
    name: "MetroWorkspace",
    rent: 60000,
    address: "Banjara Hills, Hyderabad",
    image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLE9719hikR1sZEbLNXtKA6H7dxduhCHRQTQ&s"
  }
];

function App() {
  const heading = React.createElement('h1', null, 'Office Space , at Affordable Range');
  const officeElements = offices.map((office, index) => {
    const img = React.createElement('img', {
      src: office.image,
      alt: office.name,
      // style: { width: '100%', borderRadius: '5px' }
      style: { width: '50%'}
    });

    const name = React.createElement('h2', null, office.name);
    const address = React.createElement('p', null, office.address);
    const rent = React.createElement(
      'p',
      {
        style: { color: office.rent < 60000 ? 'red' : 'green' }
      },
      `Rent: ₹${office.rent}`
    );

    return React.createElement(
      'div',
      {
        key: index,
        style: {
          border: '1px solid #ccc',
          padding: '10px',
          margin: '10px',
          borderRadius: '8px',
          width: '300px',
          boxShadow: '2px 2px 5px rgba(0,0,0,0.1)'
        }
      },
      img,
      name,
      address,
      rent
    );
  });

  const container = React.createElement(
    'div',
    {
      style: {
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'center',
        gap: '20px',
        fontFamily: 'Arial, sans-serif'
      }
    },
    ...officeElements
  );

  return React.createElement('div', { className: 'App' }, heading, container);
}

export default App;

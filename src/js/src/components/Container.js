import React from 'react';

const Container = props => (
    <div style={{width: '1400px', margin: '50px auto', textAlign: 'center'}}>
        {props.children}
    </div>
);

export default Container;
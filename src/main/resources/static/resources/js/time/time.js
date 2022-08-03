"use strict";


$(()=>{
    new Join();
})

export class Join
{
    constructor() {
        console.log('join')
        this.eventBindgin();
    }

    eventBindgin() {
        $("#saveBtn").on('click', (e) => {

            $('form').submit();


        });
    }
}
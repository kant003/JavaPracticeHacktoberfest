const coffeMachine = {
    sugarAmount: 5,
    type: 'solo',
    do : function () {

        setTimeout(() => {
            console.log('Cafe servido: ' + this.type)
        } , 3000)
    }
}

coffeMachine.do()
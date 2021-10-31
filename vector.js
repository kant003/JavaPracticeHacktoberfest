
class Vector{
    constructor(x,y){
        this.x = x
        this.y = x
    }

    rota(grados){
        const radianes = grados * (Math.PI/180);
        this.x = (this.x * Math.cos(radianes)) - (this.y * Math.sin(radianes));
	    this.y = (this.x * Math.sin(radianes)) + (this.y * Math.cos(radianes));
    }

   /* longitud(){
        const catetosCuadrado = this.x * this.x + this.y * this.y;
        return logMath.sqrt(catetosCuadrado);
    }

    normaliza(){
        if (length === 0) {
            this.x = 1;
            this.y = 0;
        } else {
            this.x /= length
            this.y /= length
        }
    }*/

}

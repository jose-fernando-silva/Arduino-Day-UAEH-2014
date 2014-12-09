package constancias

class Taller {
	Integer id
	String nombre 
	Integer numeroLugares

    static constraints = {
    	nombre nullable: false, maxSize: 50
    	numeroLugares nullable: false
    }

    String toString() {
    	nombre
    }
}
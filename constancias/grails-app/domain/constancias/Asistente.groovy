package constancias

class Asistente {
	Integer id
	String nombres
	String apellidos
	String correoElectronico
	String nivelAcademico
	Taller taller
	Boolean constancia = false
	Boolean asistencia = false 
 
    static constraints = {
		nombres nullable: false, maxSize: 30
		apellidos nullable: false, maxSize: 30
		correoElectronico nullable: false, maxSize: 50, email: true
		nivelAcademico nullable: false, inList: ["Bachillerato", "Licenciatura", "Maestría", "Otro"]
		taller nullable: true
		constancia nullable: false
		asistencia nullable: false
    }

    static mapping = {
        id column: "noFolio"
    }

    String toString() {
    	"${apellidos} ${nombres}"
    }
}


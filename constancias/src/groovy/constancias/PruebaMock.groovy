package constancias

class PruebaMock {

    static Prueba mock( id ) {

        def instance = new Prueba(
            nombres:'A',
            apellidos:'A',
            correoElectronico:'a@a.com',
            nivelAcademico:'Bachillerato',
            taller:null,
            constancia:true,
            asistencia:true,
        )
        instance

    }

}
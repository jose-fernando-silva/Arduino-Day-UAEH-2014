package constancias

class AsistenteMock {

    static Asistente mock( id ) {

        def instance = new Asistente(
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
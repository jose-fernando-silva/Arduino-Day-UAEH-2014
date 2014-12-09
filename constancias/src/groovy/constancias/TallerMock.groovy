package constancias

class TallerMock {

    static Taller mock( id ) {

        def instance = new Taller(
            nombre:'A',
            numeroLugares:1,
        )
        instance

    }

}
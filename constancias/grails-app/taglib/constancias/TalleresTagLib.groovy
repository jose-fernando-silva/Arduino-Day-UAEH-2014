package constancias

class TalleresTagLib {
    //static defaultEncodeAs = 'html'
    //static encodeAsForTags = [tagName: 'raw']

    def talleresRestantes= { attrs, body ->
    	def talleres = Taller.list()
    	def respuesta = ""
						
		if(talleres.size() == 0) {
			respuesta += "<select class='form-control' id='taller' name='taller.id'>"
			respuesta += "<option value='null'>No hay talleres disponibles</option>"
		} else {
			def asistenteActual = attrs.asistente
			def tallerAsistente = Taller.findByNombre(asistenteActual?.taller)
			def agregar = ""
			
			def existenLugares = false
			talleres.each { taller ->
				def numAsistentesEnTaller = Asistente.countByTaller(taller)
				def lugaresRestantes = taller.numeroLugares - numAsistentesEnTaller
				
				if(lugaresRestantes > 0) {
					existenLugares = true
					def selected = (tallerAsistente?.id == taller?.id) ? "selected" : ""
					respuesta += "<option value='${taller.id}' ${selected}>${taller} (Lugares restantes: ${lugaresRestantes})</option>"
				}
				//cuando hay lugar en otros pero no en el del asistente mostrar su taller
				if(tallerAsistente?.id == taller?.id && lugaresRestantes == 0)
					agregar = "<option value='${tallerAsistente.id}' selected>${tallerAsistente} (Lugares restantes: 0)</option>"
			
			}
			if(existenLugares) {
				respuesta = "<select class='form-control' id='taller' name='taller.id'>" + 
				"<option value='null'></option>" +
				agregar + 
				respuesta
			} else { //Cuando no hay lugares en ningun taller
				def aux = respuesta
				respuesta = "<select class='form-control' id='taller' name='taller.id'>"
				if(tallerAsistente)
					respuesta += "<option value='${tallerAsistente.id}' selected>${tallerAsistente} (Lugares restantes: 0)</option>"

				respuesta += "<option value='null'>No hay talleres disponibles</option>" + aux
			}
		}	
		respuesta += "</select>"
    	out << respuesta 
    }

    def totalAlumnosTaller= { attrs, body ->
    	def taller = Taller.get(attrs.taller)
        def asistentes = Asistente.countByTaller(taller)
        out << "Total: ${asistentes}"
    }
}

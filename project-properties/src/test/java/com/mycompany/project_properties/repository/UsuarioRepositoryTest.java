package com.mycompany.project_properties.repository;

import com.mycompany.project_properties.domain.Usuario;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class UsuarioRepositoryTest {

    @Autowired //inyección de dependencias
    private UsuarioRepository usuarioRepository;

    @Test
    @Order(1)

    void insert() {
        Usuario usuario = new Usuario(null, "karen", "perla", "Escalante", "Figueroa");
        Usuario usuarioguardado = usuarioRepository.save(usuario);

        assertNotNull(usuarioguardado.getId());// preguntando si el usuario se inserto en base de datos y me devolvio objecid

        Usuario usuarioTest = usuarioRepository.findById(usuarioguardado.getId()).orElse(null);//Buscando el usuario por id
        assertNotNull(usuarioTest);// pregunta si el usuario existe
        assertEquals(usuarioguardado.getId(), usuarioTest.getId());//compara el usuario que guarda con el usuario que consulta
        assertEquals( "karen",usuarioTest.getPrimerNombre());// compara el primer nombre del usuario que guarde con el que consulte
        assertEquals("perla",usuarioTest.getSegundoNombre());// compara el segundo nombre del usuario que guarda con el que consulta
        assertEquals("Escalante", usuarioTest.getPrimerApellido());
        assertEquals("Figueroa", usuarioTest.getSegundoApellido());
    }


    @Test
    @Order(2)
    void update() {
        Usuario usuario = new Usuario(null, "karen", "perla", "Escalante", "Figueroa");
        Usuario usuarioguardado = usuarioRepository.save(usuario);

        assertNotNull(usuarioguardado.getId());

        Usuario usuarioTest = usuarioRepository.findById(usuarioguardado.getId()).orElse(null); // busca el usuario por id
        usuarioTest.setPrimerApellido("Vinazco"); // cambiando el primer apellido del usuario
         usuarioTest.setSegundoApellido("Gomez"); // camiando el segundo
        usuarioTest.setPrimerNombre("Lizeth");
        usuarioTest.setSegundoNombre("Perla");
        usuarioRepository.save(usuarioTest); //guardo el usuario

        Usuario usuarioTestModificado =usuarioRepository.findById(usuarioTest.getId()).orElse(null);

        assertNotNull(usuarioTestModificado); //pregunta si el usuario existe
        assertEquals(usuarioTest.getId(), usuarioTestModificado.getId()); //compara el usuario que guarde con el usuario que consulta
        assertEquals("Lizeth", usuarioTestModificado.getPrimerNombre()); // compara el primer nombre del usuario que guarde con el que consulte
        assertEquals("Perla", usuarioTestModificado.getSegundoNombre()); // compara el primer nombre del usuario que guarde con el que consulte
        assertEquals("Vinazco", usuarioTestModificado.getPrimerApellido()); // compara el primer nombre del usuario que guarde con el que consulte
        assertEquals("Gomez", usuarioTestModificado.getSegundoApellido()); // compara el primer nombre del usuario que guarde con el que consulte
    }

    @Test
    @Order(3)
    void delete() {
        Usuario usuario = new Usuario(null, "karen", "perla", "Escalante", "Figueroa");
        Usuario usuarioguardado = usuarioRepository.save(usuario);

        assertNotNull(usuarioguardado.getId());

        Usuario usuarioTest = usuarioRepository.findById(usuarioguardado.getId()).orElse(null);
        usuarioRepository.delete(usuarioTest); // elminando el usuario

        Usuario usuarioTestEliminado = usuarioRepository.findById(usuarioTest.getId()).orElse(null);
        assertEquals(usuarioTestEliminado, null); //pregunta si el usuario existe debe ser null porque se elimino
    }


}
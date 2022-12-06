package io.quarkus.resources;

import io.quarkus.domain.Cliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import io.quarkus.domain.Usuario;

@ExtendWith(MockitoExtension.class)
public class ClienteResourceMockTest {
    @Mock
    ClienteResource clienteBase;

    @Mock
    Usuario usuario;

    @Test
    public void testLogin() {
        when(clienteBase.login("admin", "admin") ).thenReturn(true);
        assertEquals(true, clienteBase.login("admin", "admin"));
    }

    /**
     * 
     */
    @Test
    public void testAlteraCliente() {
        Long id = (long) 2;
        Cliente c = new Cliente();
        c.setLogin("meri");
        c.setSenha("teste");
        c.setNome("Meridiane");
        c.setCpf("111-111-111-12");
        c.setEndereco("rua b");

        when(clienteBase.alteraDadosCliente(id, c)).thenReturn(true);
        assertEquals(true, clienteBase.alteraDadosCliente(id, c));

    }

}

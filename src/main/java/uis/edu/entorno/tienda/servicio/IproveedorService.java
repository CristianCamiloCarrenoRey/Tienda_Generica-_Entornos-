package uis.edu.entorno.tienda.servicio;

import java.util.List;
import uis.edu.entorno.tienda.modelo.Proveedor;

public interface IproveedorService {

    List<Proveedor> getProveedores();
    Proveedor nuevoProveedor(Proveedor proveedor);
    Proveedor buscarProveedor(Long id);
    int borrarProveedor(Long id);
}
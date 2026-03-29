package uis.edu.entorno.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entorno.tienda.modelo.Producto;
import uis.edu.entorno.tienda.modelo.Proveedor;
import uis.edu.entorno.tienda.repositorio.ProveedorRepo;

@Service
@Transactional
public class ProvedorService implements IproveedorService {

    @Autowired
    ProveedorRepo proveedorRepo;

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRepo.findAll();
    }

    @Override
    public Proveedor nuevoProveedor(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    @Override
    public Proveedor buscarProveedor(Long id) {
		// buscar por  id 
		Proveedor proveedor= null;
		proveedor = proveedorRepo.findById(id).orElse(null);
		
		if(proveedor == null) {
			return null;
		}
		
		return proveedor;
	}
    

    @Override
    public int borrarProveedor(Long id) {
        proveedorRepo.deleteById(id);
        return 1;
    }
    
}
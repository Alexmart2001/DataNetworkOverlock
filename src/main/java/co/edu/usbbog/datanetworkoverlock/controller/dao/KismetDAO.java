package co.edu.usbbog.datanetworkoverlock.controller.dao;
import co.edu.usbbog.datanetworkoverlock.model.KismetDTO;
import java.util.List;

public interface KismetDAO {
    public boolean create(KismetDTO kismet);
    public boolean edit(KismetDTO kismet);
    public boolean remove(Integer id_analisis_kismet);
    public KismetDTO find (Integer id_analisis_kismet);
    public List<KismetDTO> findAll();
    public int count();
}

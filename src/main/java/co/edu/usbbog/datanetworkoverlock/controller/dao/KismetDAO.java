package co.edu.usbbog.datanetworkoverlock.controller.dao;
import co.edu.usbbog.datanetworkoverlock.model.KismetDTO;
import java.util.List;

public interface KismetDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public KismetDTO find ();
    public List<KismetDTO> findAll();
}

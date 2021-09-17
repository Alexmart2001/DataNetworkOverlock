package co.edu.usbbog.datanetworkoverlock.model;

import co.edu.usbbog.datanetworkoverlock.controller.dao.BackdoorDAO;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDAOImpl;

public class BackdoorBO {

    private final BackdoorDAO backdoorDAO;

    public BackdoorBO(){
        this.backdoorDAO = BackdoorDAOImpl();
    }

    public String crearBackdoor()
}

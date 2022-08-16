package org.sid.gestapprobackend.entities;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "CommandProjection", types = {org.sid.gestapprobackend.entities.Command.class})
public interface CommandView {
    public Long getOid();

    public String getAsknum();

    public Date getAskdate();

    public String getNumcmd();

    public  Date getDatecmd();

    public  Integer getDelevrytime();

    public Integer getReduction();

    public Coastcenter getCoastcenter();

    public Company getCompany();

    public Warehouse getWarehouse();

    public State getState();

    public Provider getProvider();
}
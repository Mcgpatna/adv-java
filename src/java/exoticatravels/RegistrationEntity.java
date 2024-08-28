/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "REGISTRATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrationEntity.findAll", query = "SELECT r FROM RegistrationEntity r")
    , @NamedQuery(name = "RegistrationEntity.findByUsername", query = "SELECT r FROM RegistrationEntity r WHERE r.username = :username")
    , @NamedQuery(name = "RegistrationEntity.findByUserid", query = "SELECT r FROM RegistrationEntity r WHERE r.emailid = :emailid")
    , @NamedQuery(name = "RegistrationEntity.findByPassword", query = "SELECT r FROM RegistrationEntity r WHERE r.password = :password")
    , @NamedQuery(name = "RegistrationEntity.findByAddress", query = "SELECT r FROM RegistrationEntity r WHERE r.address = :address")
    , @NamedQuery(name = "RegistrationEntity.findByState", query = "SELECT r FROM RegistrationEntity r WHERE r.state = :state")
    , @NamedQuery(name = "RegistrationEntity.findByCountry", query = "SELECT r FROM RegistrationEntity r WHERE r.country = :country")
    , @NamedQuery(name = "RegistrationEntity.findByGroupname", query = "SELECT r FROM RegistrationEntity r WHERE r.groupname = :groupname")})
public class RegistrationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "USERNAME")
    private String username;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "EMAILID")
    private String emailid;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 150)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 25)
    @Column(name = "STATE")
    private String state;
    @Size(max = 25)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 25)
    @Column(name = "GROUPNAME")
    private String groupname;

    public RegistrationEntity() {
    }

    public RegistrationEntity(String emailid) {
        this.emailid = emailid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailid != null ? emailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistrationEntity)) {
            return false;
        }
        RegistrationEntity other = (RegistrationEntity) object;
        if ((this.emailid == null && other.emailid != null) || (this.emailid != null && !this.emailid.equals(other.emailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "exoticatravels.RegistrationEntity[ emailid=" + emailid + " ]";
    }
    
}

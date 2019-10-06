/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "product", catalog = "point_of_sales_system", schema = "")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByPid", query = "SELECT p FROM Product p WHERE p.pid = :pid"),
    @NamedQuery(name = "Product.findByPname", query = "SELECT p FROM Product p WHERE p.pname = :pname"),
    @NamedQuery(name = "Product.findByPprice", query = "SELECT p FROM Product p WHERE p.pprice = :pprice"),
    @NamedQuery(name = "Product.findByPqty", query = "SELECT p FROM Product p WHERE p.pqty = :pqty"),
    @NamedQuery(name = "Product.findByPsupplier", query = "SELECT p FROM Product p WHERE p.psupplier = :psupplier")})
public class Product implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pid")
    private String pid;
    @Basic(optional = false)
    @Column(name = "pname")
    private String pname;
    @Basic(optional = false)
    @Column(name = "pprice")
    private String pprice;
    @Basic(optional = false)
    @Column(name = "pqty")
    private int pqty;
    @Basic(optional = false)
    @Column(name = "psupplier")
    private String psupplier;

    public Product() {
    }

    public Product(String pid) {
        this.pid = pid;
    }

    public Product(String pid, String pname, String pprice, int pqty, String psupplier) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.pqty = pqty;
        this.psupplier = psupplier;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        String oldPid = this.pid;
        this.pid = pid;
        changeSupport.firePropertyChange("pid", oldPid, pid);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        String oldPname = this.pname;
        this.pname = pname;
        changeSupport.firePropertyChange("pname", oldPname, pname);
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        String oldPprice = this.pprice;
        this.pprice = pprice;
        changeSupport.firePropertyChange("pprice", oldPprice, pprice);
    }

    public int getPqty() {
        return pqty;
    }

    public void setPqty(int pqty) {
        int oldPqty = this.pqty;
        this.pqty = pqty;
        changeSupport.firePropertyChange("pqty", oldPqty, pqty);
    }

    public String getPsupplier() {
        return psupplier;
    }

    public void setPsupplier(String psupplier) {
        String oldPsupplier = this.psupplier;
        this.psupplier = psupplier;
        changeSupport.firePropertyChange("psupplier", oldPsupplier, psupplier);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sm.Product[ pid=" + pid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

package src.Entities;

import src.Entities.Person.Customer;
import src.Entities.Person.Seller;
import src.Entities.ValueObjects.Address;
import src.Interfaces.IPresentate;

import java.util.ArrayList;

public class Store implements IPresentate
{
    public String razaoSocial;
    public String fantasyName;
    public Address address;
    public ArrayList<Seller> sellers = new ArrayList<Seller>();
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    public String cnpj;
    public int CustomerCount()
    {
        return this.customers.toArray().length;
    }
    public int SellerCount()
    {
        return this.sellers.toArray().length;
    }
    public Store(String razaoSocial, String fantasyName, Address address, String cnpj)
    {
        this.razaoSocial = razaoSocial;
        this.fantasyName = fantasyName;
        this.address = address;
        this.cnpj = cnpj;
    }
    public String presentate()
    {
        return " Nome Fantasia: " + this.fantasyName + "Cnpj: " + this.cnpj + "Endereco: " + this.address.presentate();
    }

}

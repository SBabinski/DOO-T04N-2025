package src.Entities;

public class Store
{
    public String razaoSocial;
    public String fantasyName;
    public String cnpj;
    public String city;
    public String neighborhood;
    public String street;
    publuc Seller[] sellers;
    public Customer[] customers;

    public int CustomerCount()
    {
        return this.customers.length;
    }
    public int SellerCount()
    {
        return this.sellers.length;
    }
    public String presentate()
    {
        return " Nome Fantasia: " + this.fantasyName + "Cnpj: " + this.cnpj + "Endereco: " + this.street + " Bairro: " + this.neighborhood + " Cidade: " + this.city;
    }

}

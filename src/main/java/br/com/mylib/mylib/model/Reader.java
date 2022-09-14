package br.com.mylib.mylib.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Reader extends Person{

    @OneToMany
    private List<Book> wishList;
    @OneToMany
    private List<Book> rentedList;

    public List<Book> getWishList() {
        return wishList;
    }

    public void setWishList(List<Book> wishList) {
        this.wishList = wishList;
    }

    public List<Book> getRentedList() {
        return rentedList;
    }

    public void setRentedList(List<Book> rentedList) {
        this.rentedList = rentedList;
    }
}

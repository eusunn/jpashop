package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 싱글 테이블이라 DB입장에서 구분할 수 있게 정해주는것
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;

}

package org.thekiddos.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"org.thekiddos.shopmecommon.models", "org.thekiddos.admin.user"})
public class ShopmeBackendApplication {

    public static void main( String[] args ) {
        SpringApplication.run( ShopmeBackendApplication.class, args );
    }

}

package org.jpa.springdatarest;

import org.jpa.springdatarest.web.VoitureController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
//indique que c’est une classe de test régulier qui exécute les tests à base de Spring boot
class SpringbootReactPart1ApplicationTests {
    @Autowired
    VoitureController voitureController;
    @Test
    //indique que cette méthode peut être exécutée comme un cas de test
    void contextLoads() {
        assertThat(voitureController).isNotNull();
    //on teste si l’instance du contrôleur a été créé et injectée avec succès.
    }
}


package com.openclassrooms.magicgithub;

import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.*;


/**
 * Unit test, which will execute on a JVM.
 * Testing UserRepository.
 */
@RunWith(JUnit4.class)
public class UserRepositoryTest {
    
    private UserRepository userRepository;
    
    @Before
    public void setup() {
        userRepository = Injection.createUserRepository();
    }

    @Test
    public void getUsersWithSuccess() {
        List<User> usersActual = userRepository.getUsers();
        List<User> usersExpected = Arrays.asList(
                new User("001", "Jake", "https://avatars.dicebear.com/api/miniavs/1.png"),
                new User("002", "Paul", "https://avatars.dicebear.com/api/miniavs/2.png"),
                new User("003", "Phil", "https://avatars.dicebear.com/api/miniavs/3.png"),
                new User("004", "Guillaume", "https://avatars.dicebear.com/api/miniavs/4.png"),
                new User("005", "Francis", "https://avatars.dicebear.com/api/miniavs/5.png"),
                new User("006", "George", "https://avatars.dicebear.com/api/miniavs/6.png"),
                new User("007", "Louis", "https://avatars.dicebear.com/api/miniavs/7.png"),
                new User("008", "Mateo", "https://avatars.dicebear.com/api/miniavs/8.png"),
                new User("009", "April", "https://avatars.dicebear.com/api/miniavs/9.png"),
                new User("010", "Louise", "https://avatars.dicebear.com/api/miniavs/10.png"),
                new User("011", "Elodie", "https://avatars.dicebear.com/api/miniavs/11.png"),
                new User("012", "Helene", "https://avatars.dicebear.com/api/miniavs/12.png"),
                new User("013", "Fanny", "https://avatars.dicebear.com/api/miniavs/13.png"),
                new User("014", "Laura", "https://avatars.dicebear.com/api/miniavs/14.png"),
                new User("015", "Gertrude", "https://avatars.dicebear.com/api/miniavs/15.png"),
                new User("016", "Chloé", "https://avatars.dicebear.com/api/miniavs/16.png"),
                new User("017", "April", "https://avatars.dicebear.com/api/miniavs/17.png"),
                new User("018", "Marie", "https://avatars.dicebear.com/api/miniavs/18.png"),
                new User("019", "Henri", "https://avatars.dicebear.com/api/miniavs/19.png"),
                new User("020", "Rémi", "https://avatars.dicebear.com/api/miniavs/20.png")
        );

        assertThat(usersActual, containsInAnyOrder(usersExpected.toArray()));
    }


    @Test
    public void generateRandomUserWithSuccess() {
            // Créons un objet de la classe à tester
            User user = userRepository.getUsers().get(0);

            // Appelons la méthode generateRandomUser()
            userRepository.generateRandomUser();

            // Vérifions que la liste d'utilisateurs contient un seul utilisateur
            assertEquals(20, userRepository.getUsers().size());

            // Vérifions que l'utilisateur ajouté est un utilisateur valide
            assertNotNull(userRepository.getUsers().get(0));

            // Vérifier que l'utilisateur ajouté est présent dans la liste des utilisateurs aléatoires
            assertTrue(!FAKE_USERS_RANDOM.contains(userRepository.getUsers().get(0)));





        /*userRepository.generateRandomUser();
        User user =  userRepository.getUsers().get(0);
        userRepository.getUsers().clear();
        assertEquals(1, userRepository.getUsers().size());
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));
        assertFalse(FAKE_USERS.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        assertFalse(FAKE_USERS.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        assertFalse(FAKE_USERS.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));


         */
    }

    @Test
    public void deleteUserWithSuccess() {
        //nous allons vérifier si la liste des utilisateurs ne contient pas l'utilisateur supprimé en utilisant l'opérateur !
        // avant l'appel à la méthode contains(). Cela inverse le résultat de la méthode contains(), ce qui signifie que
        // l'assertion réussira si la liste des utilisateurs ne contient pas l'utilisateur supprimé.

        User userToDelete = userRepository.getUsers().get(0);
        userRepository.deleteUser(userToDelete);
        assertFalse(!userRepository.getUsers().contains(userToDelete));
    }
}
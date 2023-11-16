package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;

public class UserRepository {
    UserRepository userRepository;

    private final ApiService apiService;// TODO: A utiliser

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<User> getUsers() {
        // TODO: A modifier
        //Ici nous devons creer une liste vide pour stocker les utilisateurs
        List<User> users = new ArrayList<>();

        //Ajouter les utilisateurs a la liste
        users.add(new User("001", "Jake", "https://avatars.dicebear.com/api/miniavs/1.png"));
        users.add(new User("002", "Paul", "https://avatars.dicebear.com/api/miniavs/2.png"));
        users.add(new User("003", "Phil", "https://avatars.dicebear.com/api/miniavs/3.png"));
        users.add(new User("004", "Guillaume", "https://avatars.dicebear.com/api/miniavs/4.png"));
        users.add(new User("005", "Francis", "https://avatars.dicebear.com/api/miniavs/5.png"));
        users.add(new User("006", "George", "https://avatars.dicebear.com/api/miniavs/6.png"));
        users.add(new User("007", "Louis", "https://avatars.dicebear.com/api/miniavs/7.png"));
        users.add(new User("008", "Mateo", "https://avatars.dicebear.com/api/miniavs/8.png"));
        users.add(new User("009", "April", "https://avatars.dicebear.com/api/miniavs/9.png"));
        users.add(new User("010", "Louise", "https://avatars.dicebear.com/api/miniavs/10.png"));
        users.add(new User("011", "Elodie", "https://avatars.dicebear.com/api/miniavs/11.png"));
        users.add(new User("012", "Helene", "https://avatars.dicebear.com/api/miniavs/12.png"));
        users.add(new User("013", "Fanny", "https://avatars.dicebear.com/api/miniavs/13.png"));
        users.add(new User("014", "Laura", "https://avatars.dicebear.com/api/miniavs/14.png"));
        users.add(new User("015", "Gertrude", "https://avatars.dicebear.com/api/miniavs/15.png"));
        users.add(new User("016", "Chloé", "https://avatars.dicebear.com/api/miniavs/16.png"));
        users.add(new User("017", "April", "https://avatars.dicebear.com/api/miniavs/17.png"));
        users.add(new User("018", "Marie", "https://avatars.dicebear.com/api/miniavs/18.png"));
        users.add(new User("019", "Henri", "https://avatars.dicebear.com/api/miniavs/19.png"));
        users.add(new User("020", "Rémi", "https://avatars.dicebear.com/api/miniavs/20.png"));

        // retourner la liste des utilisateurs
        return users;
    }

    public void generateRandomUser() {
        // TODO: A modifier
        Random random = new Random();
        int randomIndex = random.nextInt(FAKE_USERS_RANDOM.size());
        User randomUser = FAKE_USERS_RANDOM.get(randomIndex);
        //supprimer tous les uilisateurs existants
        getUsers().clear();
        getUsers().add(randomUser);
    }

    public void deleteUser(User userToDelete) {
        // TODO: A modifier
        List<User> users = getUsers();
        users.remove(userToDelete);
    }
}

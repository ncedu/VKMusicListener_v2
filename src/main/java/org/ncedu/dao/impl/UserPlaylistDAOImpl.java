package org.ncedu.dao.impl;

import org.ncedu.dao.UserPlaylistDAO;
import org.ncedu.entity.User_Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by nick on 28.11.16.
 */
@Repository
public class UserPlaylistDAOImpl implements UserPlaylistDAO {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public void addUserPlaylist(User_Playlist user_playlist) {
        hibernateTemplate.save(user_playlist);
    }
}

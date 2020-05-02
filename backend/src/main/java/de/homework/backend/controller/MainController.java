/*
 * Copyright (C) Check24 Vergleichsportal Baufinanzierung GmbH - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Andrey Sorokin on 28.04.2020
 */

package de.homework.backend.controller;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.homework.backend.models.Peer;

@CrossOrigin(origins = {"https://localhost:9000", "https://localhost:9001", "https://192.168.178.39:9000", "https://192.168.178.39:9001"}, maxAge = 3600)
@RestController
public class MainController {

    private final Logger log = LoggerFactory.getLogger(MainController.class);

    private static final Set<String> peers = new HashSet<>();

    @GetMapping
    public Set<String> getPeers() {
        log.info("getPeers() " + peers);
        return peers;
    }

    @PostMapping
    public Set<String> addPeer(@RequestBody final Peer peer) {
        log.info(peer.toString());
        peers.add(peer.getName());

        return peers;
    }

    @DeleteMapping
    public Set<String> removePeer(@RequestBody final String peerId) {
        peers.remove(peerId.replace("=", ""));

        return peers;
    }
}

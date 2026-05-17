let scene, camera, renderer, cube;

/*  ЗВУК (toggle play/stop) */

let currentAudio = null;

function playSound(id) {

    const audio = document.getElementById(id);
    if (!audio) return;

    //  если этот же звук уже играет → остановить
    if (currentAudio === audio && !audio.paused) {
        audio.pause();
        currentAudio = null;
        return;
    }

    //  если играет другой звук → остановить его
    if (currentAudio && currentAudio !== audio) {
        currentAudio.pause();
        currentAudio.currentTime = 0;
    }

    //  запустить выбранный звук
    audio.play();
    currentAudio = audio;
}


/*  3D СЦЕНА */

function init3D() {

    scene = new THREE.Scene();

    camera = new THREE.PerspectiveCamera(
        75,
        window.innerWidth / 450,
        0.1,
        1000
    );

    renderer = new THREE.WebGLRenderer({
        canvas: document.getElementById("threeCanvas")
    });

    renderer.setSize(window.innerWidth, 450);

    cube = new THREE.Mesh(
        new THREE.BoxGeometry(),
        new THREE.MeshBasicMaterial({ color: 0x1e6bff })
    );

    scene.add(cube);

    camera.position.z = 3;

    animate();
}


/*  АНИМАЦИЯ */

function animate() {

    requestAnimationFrame(animate);

    cube.rotation.y += 0.02;

    renderer.render(scene, camera);
}


/*  3D TOGGLE */

function toggle3D() {

    const canvas = document.getElementById("threeCanvas");

    if (canvas.style.display === "block") {
        canvas.style.display = "none";
        return;
    }

    canvas.style.display = "block";

    if (!scene) {
        init3D();
    }
}
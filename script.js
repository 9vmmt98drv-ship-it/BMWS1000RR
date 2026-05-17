let scene, camera, renderer, cube;

/* ЗВУК */

function playSound(id) {

    let audio = document.getElementById(id);

    audio.currentTime = 0;

    audio.play();
}

/* 3D */

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

        new THREE.MeshBasicMaterial({

            color: 0x1e6bff
        })
    );

    scene.add(cube);

    camera.position.z = 3;

    animate();
}

/* АНИМАЦИЯ */

function animate() {

    requestAnimationFrame(animate);

    cube.rotation.y += 0.02;

    renderer.render(scene, camera);
}

/* ПОКАЗАТЬ 3D */

function toggle3D() {

    let canvas = document.getElementById("threeCanvas");

    if (canvas.style.display === "block") {

        canvas.style.display = "none";

    } else {

        canvas.style.display = "block";

        if (!scene) {

            init3D();
        }
    }
}
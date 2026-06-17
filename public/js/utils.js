document.addEventListener("DOMContentLoaded", () => {
    document.body.insertAdjacentHTML("afterbegin", `
        <nav class="navbar navbar-expand-lg bg-body-tertiary mb-3">
            <div class="container">
                <a class="navbar-brand" href="/index.html">
                    <i class="fa-solid fa-paw"></i> ZooIndex
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="/index.html">
                                <i class="fa-solid fa-house"></i> Pocetna
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/genus.html">
                                <i class="fa-solid fa-sitemap"></i> Rodovi
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/fact.html">
                                <i class="fa-solid fa-lightbulb"></i> Zanimljivosti
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    `);
});

const bootstrapClasses = {
    popup: "card",
    cancelButton: "btn btn-danger",
    denyButton: "btn btn-secondary",
    confirmButton: "btn btn-primary"
};

function showLoading() {
    Swal.fire({
        title: "Podaci se ucitavaju",
        text: "Molimo sacekajte.",
        allowOutsideClick: false,
        customClass: bootstrapClasses,
        didOpen: () => {
            Swal.showLoading();
        }
    });
}

function showConfirm(msg, callback) {
    Swal.fire({
        title: msg,
        showCancelButton: true,
        confirmButtonText: "Da",
        cancelButtonText: "Odustani",
        icon: "question",
        customClass: bootstrapClasses
    }).then(result => {
        if (result.isConfirmed) {
            callback();
        }
    });
}

async function retrieveData(url, callback) {
    showLoading();
    const rsp = await fetch(url);
    const data = await rsp.json();
    callback(data);
    Swal.close();
}

function openPage(url) {
    window.location.href = url;
}

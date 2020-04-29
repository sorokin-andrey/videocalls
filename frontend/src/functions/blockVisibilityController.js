
export function blockVisibilityController(data) {
    if (data != null && data.length > 0) {
        document.getElementById("login").style.display = 'none';
        document.getElementById("conference").style.display = 'block';
    } else {
        document.getElementById("login").style.visibility = 'block';
        document.getElementById("conference").style.visibility = 'none';
    }
}
const contraseñas = ['Pass123', 'pass1234567', 'pass123456789', 'pass1234567890'];

const validatePasswords = (passwords) => {
    return passwords.every(password => {
        const minusculas = /[a-z]/.test(password);
        const mayusculas = /[A-Z]/.test(password);
        const numero = /\d/.test(password);
        const largo = password.length >= 8;

        return minusculas && mayusculas && numero && largo;
    });
};
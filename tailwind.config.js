/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/static/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        primary: '#3B82F6',
        secondary: '#10B981',
      }
    },
  },
  plugins: [
    require('daisyui'),
  ],
}
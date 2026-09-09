import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'

export default defineConfig({
  plugins: [react()],

  server: {
    allowedHosts: [
      'spring-boot-app-api-env-1.eba-y9mqp5tm.eu-west-3.elasticbeanstalk.com'
    ],
  },

  resolve: {
    alias: {
      '@': path.resolve(import.meta.dirname, './src'),
    },
  },
})